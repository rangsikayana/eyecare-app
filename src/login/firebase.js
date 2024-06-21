const admin = require('firebase-admin');
const serviceAccount = require('./serviceAccountKey.json');

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://eyecare-database.firebaseio.com"
});

const db = admin.firestore();
const auth = admin.auth();
module.exports = { db, auth };