from flask import Flask,jsonify,request,render_template
import pandas as pd
import json

app = Flask(__name__)

# reading employee csv file 
emp_df = pd.read_csv("employees.csv")

@app.route("/",methods = ["POST","GET"])
def home():
    if request.method == "GET":
        return render_template('index.html')
    elif request.method == "POST":
        record = json.loads(request.data)   
        print(record)
        return jsonify(record)

# @app.route("/",methods = ["POST"])
# def post_values():
    

@app.route("/employee-details",methods=["GET"])  
def get_all_emp_details(): 
    # converting dataframe to dictionary
    emp_df_dict = emp_df.to_dict(orient= 'records')
    # converting dictionary to json
    emp_json_data = jsonify({"All-Employee-Details":emp_df_dict})
    return emp_json_data

@app.route("/employee-details/<empid>",methods=["GET"])  
def get_empid_details(empid):
    # fetching employee details based on userid from dataframe and converting dataframe to json
    emp_json = emp_df.query(f'Employee_id == {empid}').to_json()
    return emp_json


if __name__ == "__main__":
    app.run(debug =True)


