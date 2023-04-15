from fastapi import FastAPI, Security, Depends, HTTPException, Header
from typing import Union
from fastapi.security.api_key import APIKeyQuery, APIKeyCookie, APIKeyHeader, APIKey

app = FastAPI()

API_KEY = "1234abcs5678efgh"
Api_Key_Name = "access_token"
api_key_qry = APIKeyQuery(name= Api_Key_Name, auto_error=False)
api_key_hder = APIKeyHeader(name= Api_Key_Name, auto_error=False)
api_key_cukie = APIKeyCookie(name= Api_Key_Name, auto_error=False)

@app.get("/")
async def root():
    return {"message": "ready"}


async def check_api_key(
    api_key_query: str = Security(api_key_qry),
    api_key_header: str = Security(api_key_hder),
    api_key_cookie: str = Security(api_key_cukie)):
    
    if api_key_query == API_KEY:
        return api_key_qry
    elif api_key_header == API_KEY:
        return api_key_hder
    elif api_key_cookie == API_KEY:
        return api_key_cukie
    else:
        raise HTTPException(403, detail="Authentication Failed: Api key not valid !")
    

# fetch historic data
@app.get("/api/v1/hs/{data_id}")
async def get_historic_data(data_id:str ,params: list, api_key: APIKey = Depends(check_api_key)):
    param_list = ["start","end"]
    for para in param_list:
        if para not in params[0]:
            raise HTTPException(404, detail=f"Parameter : {para} not found!")
    data = {"data_id": data_id, "params":{"start":params[0]["start"],"end":params[0]["end"]}, "result":"success"}
    return data
