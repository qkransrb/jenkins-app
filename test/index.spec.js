const { sayHello } = require("../index");

describe("test", function () {
  it("should be return hello", function (done) {
    if (sayHello() === "hello") {
      done();
      process.exit(0);
    }
  });
});
