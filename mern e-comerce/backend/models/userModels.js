const mongoose = require("mongoose");
const { stringify } = require("querystring");
const validator = require("validator");
const userSchema = new Mongoose.Schema({
  name: {
    type: String,
    rquire: [true, "please enter your name"],
    maxLength: [30, "name cannot exceed 30 characters"],
    minLength: [4, "name must have atleast 4 characters"],
  },
  email: {
    type: String,
    required: [true, "please enter your email"],
    unique: true,
    validate: [validator.isEmail, "please enter a valid email"],
  },
  password: {
    type: String,
    required: [true, "please enter your password"],
    minLength: [8, "password must be atleast 8 characters long"],
    select: false,
  },
  avatar: {
    public_id: {
      type: String,
      required: true,
    },
    url: {
      type: String,
      required: true,
    },
  },
  role: {
    type: String,
    default: "user",
  },
  resetPasswordToken: String,
  resetPasswordExpire: Date,
});

module.exports = mongoose.model("User", userSchema);
