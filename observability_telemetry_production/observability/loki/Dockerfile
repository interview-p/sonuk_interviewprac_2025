FROM grafana/loki:2.8.2
COPY loki-config.yaml /etc/loki/local-config.yaml
ENTRYPOINT ["/usr/bin/loki", "-config.file=/etc/loki/local-config.yaml"]
