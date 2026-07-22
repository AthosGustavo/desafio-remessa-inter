
#!/bin/bash

set -e

AMBIENTE=$1

docker compose --env-file infra/envs/.env.$AMBIENTE up