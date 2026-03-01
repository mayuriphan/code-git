import asyncio
import yaml
import argparse
from exchange_factory import create_exchange


def get_pairs() -> list[str]:
    value = os.getenv("COIN_PAIRS", "all").strip()
    if value.lower() == "all":
        return ["all"]
    return [pair.strip().upper() for pair in value.split(",") if pair.strip()]

async def run(exchange_name: str, symbol: str):
    exchange = create_exchange(exchange_name, symbol)
    await exchange.connect()
    await exchange.subscribe()


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("--exchange", type=str, help="Exchange name")
    parser.add_argument("--symbol", type=str, help="Trading symbol")

    args = parser.parse_args()

    exchange_name = args.exchange
    symbol = args.symbol

    print(exchange_name)
    print(symbol)
    asyncio.run(run(exchange_name, symbol))