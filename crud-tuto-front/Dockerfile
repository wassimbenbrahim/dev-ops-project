FROM node:alpine AS build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install --force
COPY . .

RUN npm run build --outputPath=./dist
### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY /nginx-custom.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/src/app/dist/crudtuto-Front /usr/share/nginx/html