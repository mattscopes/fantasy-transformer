FROM node:22

LABEL authors="mattscopes"

WORKDIR /app

COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

RUN npm install -g serve

#ENV PORT=5173

EXPOSE 5173

#CMD ["npm", "run", "dev"]
CMD ["serve", "-s", "dist", "-l", "5173"]