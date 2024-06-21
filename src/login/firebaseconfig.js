// Before (inline configuration)
import firebase from 'firebase/app';
import 'firebase/firestore';
import 'firebase/auth';

const firebaseConfig = {
    apiKey: "AIzaSyBl1T4ki48nC2F_n_OOt0P1Yg9WbiUehuE",
    authDomain: "eyecare-app-123.firebaseapp.com",
    projectId: "eyecare-app-123",
    storageBucket: "eyecare-app-123.appspot.com",
    messagingSenderId: "506619333364",
    appId: "1:506619333364:web:b9cd7775add90aaed62ca1",
    measurementId: "G-3JEVNQ28JE"
};

firebase.initializeApp(firebaseConfig);

// After (importing configuration)
import firebase from 'firebase/app';
import 'firebase/firestore';
import 'firebase/auth';
import firebaseConfig from './config.js'; // Assuming config.js is in the same directory

firebase.initializeApp(firebaseConfig);
