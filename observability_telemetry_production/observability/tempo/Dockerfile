FROM grafana/tempo:2.8.2
COPY tempo-config.yaml /etc/tempo/tempo.yaml
ENTRYPOINT ["/tempo", "-config.file=/etc/tempo/tempo.yaml"]
