const mongoose = require("mongoose");

const oderSchema = new mongoose.Schema({
  shippingInfo: {
    address: { type: String, required: true },
    city: { type: String, require: true },
    state: { type: String, required: true },
    country: { type: String, required: true },
    pincode: { type: Number, reqired: true },
    phoneNo: { type: Number, required: true },
  },
  orderItems: [
    {
      name: { type: String, required: true },
      price: { type: Number, required: true },
      quantity: { type: Number, required: true },
      image: { type: String, required: true },
      product: {
        type: mongoose.Schema.ObjectId,
        ref: "Product",
        required: true,
      },
    },
  ],

  user: {
    type: mongoose.Schema.ObjectId,
    ref: "User",
    required: true,
  },

  paymentInfo: {
    id: { type: String, require: true },
    status: { type: String, require: true },
  },
  paidAt: {
    type: Date,
    required: true,
  },
  itemsPrice: {
    type: Number,
    required: true,
  },
  taxPrice: {
    type: Number,
    default: 0,
    required: true,
  },
  shippingPrice: {
    type: Number,
    default: 0,
    required: true,
  },
  totalPrice: { type: Number, default: 0 },
  orderStatus: { type: String, required: true, default: "Processing" },
  deliveredAt: Date,
  createdAt: { type: Date, default: Date.now },
});

module.exports = mongoose.model("Order", oderSchema);
