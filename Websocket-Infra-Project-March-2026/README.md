In progress:

cmd: poetry run python main.py --exchange binance --symbol btcusdt

# Python Exchanges Streaming System

Real-time cryptocurrency WebSocket streaming system with pluggable exchange support.
Built using asyncio, Docker, Terraform, Ansible, and Kubernetes.

---

## Features

- Async WebSocket streaming
- Pluggable exchange architecture (factory pattern)
- Environment-based configuration
- Multi-symbol subscription support
- Dockerized application
- Infrastructure as Code (Terraform)
- Configuration management (Ansible)
- Kubernetes deployment ready
- Monitoring integration ready (Prometheus/Grafana)

---

## Tech Stack

- Python 3.11 +
- Poetry
- Docker
- Terraform
- Ansible
- Argo
- Kubernetes
- Prometheus
- Grafana

---

## Local Development

- Install dependencies  
  - `poetry install`

- Run application  
  - `export exchnage=binance`
  - `export symbol=BTCUSDT`
  - `poetry run python main.py` or `poetry run python main.py --exchange binance --symbol btcusdt`

---

