const Product = require("../models/productModel");
//create products
exports.createProduct = async (req, res, next) => {
  const product = await Product.create(req.body);
  res.status(201).json({ success: true, product });
};

//get all products -- admin
exports.getAllProducts = async (req, res) => {
  const product = await Product.find();
  res.status(200).json({ success: true, product });
};

//update products admin
exports.updateProduct = async (req, res, next) => {
  console.log(
    req.params.id +
      "----------------------------------------------------------------"
  );
  let product = await Product.findById(req.params.id);
  console.log(
    product + "----------------------------------------------------------------"
  );
  if (!product) {
    return res
      .status(500)
      .json({ success: false, message: "product not found" });
  }

  product = await Product.findByIdAndUpdate(req.params.id, req.body, {
    new: true,
    runValidators: true,
  });

  res.status(200).json({
    success: true,
    product,
  });
};

exports.deleteProduct = async (req, res, next) => {
  const product = await Product.findByIdAndDelete(req.params.id);
  if (!product) {
    return res
      .status(500)
      .json({ success: false, message: "product deletion unsuccessful" });
  }

  return res.status(200).json({ success: true, product });
};
