
const { registerUser, loginUser } = require("../login/authFunctions");
const {
  createUser,
  addEyeHealthRecord,
  addNutritionRecommendation,
  addEyeImage,
  getEyeHealthRecord,
  getItemByDiagnose,
} = require("../services/firestoreFunctions");

const routes = [
  {
    method: "POST",
    path: "/register",
    handler: async (request, h) => {
      const { email, password, firstName, lastName } = request.payload;
      const user = await registerUser(email, password, firstName, lastName);
      await createUser(user.uid, firstName, lastName, email);
      return h
        .response({ message: "User registered successfully", user })
        .code(201);
    },
  },
  {
    method: "POST",
    path: "/login",
    handler: async (request, h) => {
      const { email, password } = request.payload;
      const user = await loginUser(email, password);
      return h
        .response({ message: "User logged in successfully", user })
        .code(200);
    },
  },
  {
    method: "POST",
    path: "/users/{userId}/eyeHealthRecords",
    handler: async (request, h) => {
      const { userId } = request.params;
      const { diagnosis } = request.payload;
      await addEyeHealthRecord(userId, diagnosis);
      return h
        .response({ message: "Eye health record added successfully" })
        .code(201);
    },
  },
  {
    method: "GET",
    path: "/users/{userId}/eyeHealthRecords",
    handler: async (request, h) => {
      const { userId } = request.params;
      const response = await getEyeHealthRecord(userId);
      return h.response({ message: response }).code(201);
    },
  },
  {
    method: "POST",
    path: "/users/{userId}/nutritionRecommendations",
    handler: async (request, h) => {
      const { userId } = request.params;
      const { recommendations } = request.payload;
      await addNutritionRecommendation(userId, recommendations);
      return h
        .response({ message: "Nutrition recommendation added successfully" })
        .code(201);
    },
  },
  {
    method: "POST",
    path: "/users/{userId}/eyeImages",
    handler: async (request, h) => {
      const { userId } = request.params;
      const { imageUrl, createdAt } = request.payload;
      await addEyeImage(userId, imageUrl, createdAt);
      return h.response({ message: "Eye image added successfully" }).code(201);
    },
  },
  {
    method: "GET",
    path: "/{diagnose}",
    handler: async (request, h) => {
      const { diagnose } = request.params;
      const response = getItemByDiagnose(diagnose);
      return h.response({ message: response }).code(201);
    },
  },
];

module.exports = routes;
