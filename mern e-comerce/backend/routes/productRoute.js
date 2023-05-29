const express = require("express");
const {
  getAllProducts,
  createProduct,
  updateProduct,
  deleteProduct,
  getProductDetails,
} = require("../controllers/productControllers");
const { isAuthenticatedUser, authorizeRoles } = require("../middleware/auth");

const router = express.Router();

router.route("/products").get(getAllProducts);
router
  .route("/product/new")
  .post(isAuthenticatedUser, authorizeRoles("admin"), createProduct);
router
  .route("/product/:id")
  .put(
    isAuthenticatedUser,
    authorizeRoles("admin"),
    isAuthenticatedUser,
    updateProduct
  )
  .delete(
    isAuthenticatedUser,
    authorizeRoles("admin"),
    isAuthenticatedUser,
    deleteProduct
  )
  .get(getProductDetails);
module.exports = router;
