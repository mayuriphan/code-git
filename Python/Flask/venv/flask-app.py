from flask import Flask,jsonify,request,render_template
import pandas as pd
import json,ast

app = Flask(__name__)

# reading employee csv file 
emp_df = pd.read_csv("employees.csv")

@app.route("/",methods = ["POST","GET"])
def home():
    empid = request.form.get('Input1')
    if request.method == "GET":
        return render_template('index.html')        
    elif request.method == "POST":
        # fetching employee details based on userid from dataframe and converting dataframe to dictionary
        df_list = (emp_df.loc[emp_df['Employee_id'] == int(empid)]).to_dict("records")
        data =  df_list[0]["First Name"]
        return render_template('index.html',data = f"{data}")      

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
    df = emp_df.loc[emp_df['Employee_id'] == int(empid)]
    emp_json = jsonify(df.to_dict("records"))
    return emp_json


if __name__ == "__main__":
    app.run(debug =True)


