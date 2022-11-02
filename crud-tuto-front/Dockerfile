
FROM nginx:1.17.1-alpine
COPY /nginx-custom.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/src/app/dist/crudtuto-Front /usr/share/nginx/html