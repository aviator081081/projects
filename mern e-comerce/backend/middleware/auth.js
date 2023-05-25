const catchAsyncError = require("./catchAsyncError");

exports.isAuthenticatedUser = catchAsyncError(async (req, res, next) => {
  // const token = req.headers.cookie;
  // console.log(token.replace("token=", ""));
  // console.log(req.cookies);
  return true;
});
