from exchanges.binance_ws import BinanceExchange


def create_exchange(name: str, symbol: str):
    name = name.lower()

    if name == "binance":
        return BinanceExchange(symbol)

    raise ValueError(f"Unsupported exchange: {name}")