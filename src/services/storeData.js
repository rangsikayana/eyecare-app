const { Firestore } = require("@google-cloud/firestore");

async function storeData(id, data) {
    const db = new Firestore({
        databaseId: 'eyecare-database'
    });

    const predictCollection = db.collection("users");
    return predictCollection.doc(id).set(data);
}

module.exports = storeData;