// firestoreFunctions.js
const { db } = require('../login/firebase');

const eyeData = [
  {
    "Diagnose": "Normal_eyes",
    "Food": "Blueberries, Dark Chocolate, Carrots, Fish, Green Vegetables, Eggs, Oranges and Citrus",
    "Vitamin": "Vitamins C and E, zinc, lutein, fish oil, and omega-3 fatty acids",
    "Eye Treatments Recommendation": "Get a good night's sleep and relax your eyesight. Avoid smoking, because smoking increases the risk of developing age-related eye diseases such as macular degeneration and cataracts. If you wear contacts, take steps to prevent eye infections. Wear Sunglasses. Eat right to protect your sight."
  },
  {
    "Diagnose": "Uveitis",
    "Food": "Cruciferous Vegetables, Green Leaefy Veggies, Berries, Cherries, Tomatoes, Sweet Potatoes, Carrots and Peppers",
    "Vitamin": "A multivitamin daily, containing the antioxidant vitamins A, C, E, the B vitamins, and trace minerals, such as magnesium, calcium, zinc, and selenium.",
    "Eye Treatments Recommendation": "Eye drops with an anti-inflammatory medication, such as a corticosteroid. Eye drops to dilate the pupil and relieve pain. Wear sunglasses to protect your eyes if they are sensitive to light. Take a daily vitamin. Eat a healthy diet. Consult a doctor for further treatment."
  },
  {
    "Diagnose": "Crossed_eyes",
    "Food": "Dark Leafy Greens, Fruits, Vegetables, Fish, Nuts, Seeds, Grains, Legumes",
    "Vitamin": "Fiber, Anti-oxidants, Zinc, Beta Carotene, Omega-3, Zeaxanthin, Lutein, Vitamin A, Vitamin C, Vitamin E",
    "Eye Treatments Recommendation": "The prisms lenses can alter the light entering the eye and reduce how much turning the eye must do to view objects. Vision therapy can help problems with eye movement, eye focusing and eye teaming and reinforce the eye-brain connection, Eye muscle surgery can change the length or position of the muscles around the eyes so they appear straight."
  },
  {
    "Diagnose": "Glaucoma",
    "Food": "Fruits, Leaf Vegetables, Nuts, Fish, Dark Chocolate, Hot Tea, Banana, Avocado",
    "Vitamin": "Magnesium, Homotaurine, Carnosine, Forskolin, Folic Acid, Vitamin B1, Vitamin B2, Vitamin B6",
    "Eye Treatments Recommendation": "Prescription eye drops can lower the pressure in your eye and prevent damage to your optic nerve. To lower your eye pressure, doctors can use lasers to help the fluid drain out of your eye. If medicines and laser treatment don’t work, there are several different types of surgery that can help the fluid drain out of your eye."
  },
  {
    "Diagnose": "Cataracts",
    "Food": "Oranges, Eggs, Green Tea, Walnuts, Salmon, Carrots, Avocados, Broccoli",
    "Vitamin": "Vitamin A, Vitamin C, Lutein, Beta Carotene, Zeaxanthin, Vitamin E, Vitamin B6, Omega-3 Fatty Acids",
    "Eye Treatments Recommendation": "Cataract surgery is the only way to remove cataracts and restore your clear vision. During cataract surgery, an ophthalmologist removes your clouded natural lens and replaces it with an intraocular lens (IOL). An IOL is an artificial lens that permanently stays in your eye and replacing it with a clear artificial lens."
  },
  {
    "Diagnose": "Bulging_eyes",
    "Food": "Leafy Green Vegetables (Spinach, Broccoli, Kale), Salmon, Nuts and Seeds, Citrus Fruits, Carrot and Sweet Potatoes, Eggs, Berries (Raspberries, Blackberries, and Blueberries)",
    "Vitamin": "Vitamin A, C, E, Omega-3 Fatty Acids, Zinc, Lutein and Zeaxanthin",
    "Eye Treatments Recommendation": "To address bulging eyes, several treatment steps can be taken. The use of eye drops can help reduce irritation and keep the eyes moist. The doctor may prescribe appropriate medications if the bulging is caused by infection, swelling, or thyroid gland issues. In some cases, surgery may be necessary to correct bulging that does not resolve after other treatments. If the cause is unclear, a general practitioner may refer you to a specialist for further examination. When lying down, use a pillow to keep your head elevated to help reduce swelling. Wearing sunglasses can protect your eyes if they are sensitive to bright light. If you wear contact lenses, remove them and wear glasses to give your eyes a rest."
  }
];

async function createUser(userId, firstName, lastName, email) {
  await db.collection('users').doc(userId).set({
    name: {
      firstName: firstName,
      lastName: lastName
    },
    email: email
  });
}

async function addEyeHealthRecord(userId, diagnosis) {
  await db.collection('users').doc(userId).collection('eyeHealthRecords').add({
    diagnosis: diagnosis,
    suggestions: getItemByDiagnose(diagnosis)
  });
}

async function getEyeHealthRecord(userId) {
  try {
    const eyeHealthRecordsSnapshot = await db.collection('users').doc(userId).collection('eyeHealthRecords').get();
    const eyeHealthRecords = eyeHealthRecordsSnapshot.docs.map(doc => doc.data());
    return eyeHealthRecords;
  } catch (error) {
    console.error("Error getting eye health records: ", error);
    return [];
  }
}

async function addNutritionRecommendation(userId, recommendations) {
  await db.collection('users').doc(userId).collection('nutritionRecommendations').add({
    recommendations: recommendations
  });
}

async function addEyeImage(userId, imageUrl, createdAt) {
  await db.collection('users').doc(userId).collection('eyeImages').add({
    imageUrl: imageUrl,
    createdAt: createdAt
  });
}

function getItemByDiagnose(diagnose) {
  return eyeData.find(item => item.Diagnose === diagnose) || "Diagnose is unknown.";
}

module.exports = { createUser, addEyeHealthRecord, addNutritionRecommendation, addEyeImage, getEyeHealthRecord, getItemByDiagnose };
