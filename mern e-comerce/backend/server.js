const app = require("./app");

const dotenv = require("dotenv");
const connectDatabase = require("./config/database");
//handlig uncaught exception
process.on("uncaughtException", (err) => {
  console.log(`Error: ${err.message}`);
  console.log(`shutting down the server to uncaught Exception`);
  process.exit(1);
});
//config
dotenv.config({ path: "backend/config/config.env" });
connectDatabase();
app.listen(process.env.PORT, () => {
  console.log(`server is listening on http://localhost:${process.env.PORT}`);
});

//unhandles promise rejections
//shutdown the server as soon as these occurs
process.on("unhandledRejection", (err) => {
  console.log(`Error: ${err.message}`);
  console.log(`shutting down the server due to Unhandled promise rejections`);
  Server.close(() => {
    process.exit(1);
  });
});
