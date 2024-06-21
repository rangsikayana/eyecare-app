require("dotenv").config();

const Hapi = require("@hapi/hapi");
const routes = require("../server/routes");
const InputError = require("../exceptions/InputError");
const { createUser, addEyeHealthRecord, addNutritionRecommendation, addEyeImage } = require('../services/firestoreFunctions');
const { registerUser, loginUser } = require('../login/authFunctions');

(async () => {
  const server = Hapi.server({
      port: process.env.PORT || 8080,
      host: '0.0.0.0',
      routes: {
          cors: {
              origin: ['*'],
          },
      },
  });

//   const model = await loadModel();
//   console.log(model.batchInputShape)
//   server.app.model = model;

  // Add routes from routes.js
  server.route(routes);

  // Existing error handling
  server.ext("onPreResponse", function (request, h) {
      const response = request.response;

      if (response instanceof InputError) {
          const newResponse = h.response({
              status: "fail",
              message: "Terjadi kesalahan dalam melakukan prediksi",
          });
          newResponse.code(400);
          return newResponse;
      }

      if (response.isBoom) {
          const newResponse = h.response({
              status: "fail",
              message: response.message,
          });
          newResponse.code(413);
          return newResponse;
      }

      return h.continue;
  });

  await server.start();
  console.log(`Server start at: ${server.info.uri}`);
})();
