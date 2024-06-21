const { Firestore } = require("@google-cloud/firestore");

async function getData() {
    const db = new Firestore();

    const predictRef = db.collection("predictions");
    const snapshot = await predictRef.get();
    const data = [];
    snapshot.forEach((doc) => {
        const currData = {
            id: doc.id,
            history: doc.data()
        }
        data.push(currData);
    });
    return data;
}

module.exports = getData;