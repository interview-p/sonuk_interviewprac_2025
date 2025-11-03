FROM grafana/tempo:1.7.0
COPY tempo-config.yaml /etc/tempo/tempo.yaml
ENTRYPOINT ["/usr/bin/tempo", "-config.file=/etc/tempo/tempo.yaml"]
