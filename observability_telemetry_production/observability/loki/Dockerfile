FROM grafana/loki:2.8.2
COPY loki-config.yml /etc/loki/loki-config.yml
ENTRYPOINT ["/usr/bin/loki", "-config.file=/etc/loki/loki-config.yaml"]
