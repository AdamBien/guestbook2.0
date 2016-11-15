FROM airhacks/wildfly
COPY ./target/guestbook.war ${DEPLOYMENT_DIR}
