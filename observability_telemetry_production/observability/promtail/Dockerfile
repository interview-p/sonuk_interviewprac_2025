FROM grafana/promtail:2.8.2
COPY promtail-config.yaml /etc/promtail/promtail.yaml
ENTRYPOINT ["/usr/bin/promtail", "-config.file=/etc/promtail/promtail.yaml"]
