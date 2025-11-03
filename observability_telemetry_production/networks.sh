#!/bin/bash
set -e

echo "Creating Docker networks (idempotent)..."
docker network create infra-net 2>/dev/null || true
docker network create services-net 2>/dev/null || true
docker network create obs-net 2>/dev/null || true

echo "Networks ready: infra-net, services-net, obs-net"
