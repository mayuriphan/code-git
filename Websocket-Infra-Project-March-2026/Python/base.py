from abc import ABC, abstractmethod

class BaseExchangeClass(ABC):
    def __init__(self, symbol: str):
        self.symbol = symbol

    @abstractmethod
    async def connect(self):
        pass

    @abstractmethod
    async def subscribe(self):
        pass

    @abstractmethod
    def process(self, message: dict) -> dict:
        pass