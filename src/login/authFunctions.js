const { db, auth } = require('./firebase');

db._databaseId = "eyecare-database"

// console.log(db)

async function registerUser(email, password, firstName, lastName) {
  const userRecord = await auth.createUser({
    email: email,
    password: password,
    displayName: `${firstName} ${lastName}`
  });

  await db.collection('users').doc(userRecord.uid).set({
    name: {
      firstName: firstName,
      lastName: lastName
    },
    email: email
  });

  return userRecord;
}

async function loginUser(email, password) {
  const userRecord = await auth.getUserByEmail(email);
  
  // Placeholder for verifying password since Firebase Admin SDK does not handle password verification
  // You would typically handle this in the client-side app using Firebase Client SDK
  
  return userRecord;
}

module.exports = { registerUser, loginUser };