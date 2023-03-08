const express = require("express");

const app = express();

exports.sayHello = () => {
  return "hello";
};

app.get("/", (_, res) => {
  return res.send("Hi there!");
});

app.listen(3000, () => {
  console.log(`Listening on port 3000`);
});
