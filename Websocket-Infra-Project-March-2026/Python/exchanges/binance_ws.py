import asyncio
import json
import websockets

from base import BaseExchangeClass

class BinanceExchange(BaseExchangeClass):
    BASE_URL = "wss://stream.binance.com:9443/ws"

    async def connect(self):
        stream = f"{self.symbol.lower()}@trade"
        self.ws = await websockets.connect(f"{self.BASE_URL}/{stream}")
        print("Connected to Binance")

    async def subscribe(self):
        async for message in self.ws:
            data = json.loads(message)
            normalized = self.process(data)
            print(normalized)
            print("============================================")

    def process(self, message: dict) -> dict:
        return {
            "exchange": "binance",
            "symbol": message.get("s"),
            "price": message.get("p"),
            "quantity": message.get("q"),
            "unix_time": message.get("E")
        }