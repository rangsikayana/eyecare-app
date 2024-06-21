# EyeCare
See our wireframe <a href="https://www.figma.com/design/7yjvxqIIuj6zPrNkRZCxlJ/EyeCare-app?node-id=54795-2155&t=nxWxPQLLyFMWEk9I-0" title="Figma" target="_blank"><b>here</b></a>.

# EyeCare: Your Personal Eye Health Companion
## Theme: Health Innovation: Empowering
### Bangkit Capstone Project 2024

**Bangkit Capstone Team ID**: C241-PS466

Welcome to our repository for the Bangkit 2024 Capstone project. Our project, EyeCare, aims to help users maintain and improve their eye health through a mobile application.

## Our Team Members

| Name                     | Bangkit-ID   | Learning Path      | Contact Link                                                                                   |
|--------------------------|--------------|--------------------|------------------------------------------------------------------------------------------------|
| Tasya Nadila             | M322D4KX2820 | Machine Learning   | [LinkedIn](https://www.linkedin.com/in/tasyanadila/)                                           |
| Marlina                  | M322D4KX2250 | Machine Learning   | [LinkedIn](http://linkedin.com/in/marlina-)                                                    |
| Rangsi Ridho Kayana      | M245D4KY1523 | Machine Learning   | [LinkedIn](https://www.linkedin.com/in/rangsikayana)                                           |
| Jordan Xavier Rahmadhany | A006D4KY3519 | Mobile Development | [LinkedIn](https://www.linkedin.com/in/jordan-rahmadhany-768869220/)                           |
| Fadilano Abraham         | A009D4KY3931 | Mobile Development | [LinkedIn](http://linkedin.com/in/fadilano-abraham-1967621b3)                                  |
| Ridwan Aji Nugraha       | C006D4KY0008 | Cloud Computing    | [LinkedIn](http://www.linkedin.com/in/ridwan-aji-nugraha-99a41b2b6)                            |
| Charrisma Dwi Mahardika  | C006D4KY1164 | Cloud Computing    | [LinkedIn](https://www.linkedin.com/in/charrisma-dwi-mahardika-trisna-purnama-a777b3300/)      |


![Eyecare Team](https://github.com/rangsikayana/eyecare-app/blob/12de177c8644623265da2585ea5966ac31b0325e/assets/EyeCare_Team.jpg)

## Problem Statement
1. **Increased Screen Time:** Many people spend excessive time in front of screens for work, study, or entertainment, impacting their eye health.
2. **Limited Access to Services:** Not everyone can easily access eye health services.
3. **Late Detection:** Some eye conditions only show symptoms once they become severe.

To address these issues, we developed the EyeCare mobile app.

## Our App
EyeCare helps users detect symptoms of eye disease before consulting a doctor. It allows users to check their eyes and learn about suitable foods or nutrients. We are also considering adding features to detect symptoms of color blindness.

## Dataset
The datasets we used include:
- [Eye Disease Dataset - Kaggle](https://www.kaggle.com/datasets/kondwani/eye-disease-dataset)
- [Eye Disease with Normal_Eyes Dataset - Roboflow](https://universe.roboflow.com/muhammad-risma-nqgw8/eye-diseases-7shia/dataset/7)
- Image Scraping from the Internet
- Combined_Eye_Disease.zip dataset

## Goals & Aims

## Installation & Deployment

### Machine Learning - Project Installation
1. Clone this repository:
   ```bash
   git clone https://github.com/rangsikayana/eyecare-app.git
   ```
2. Download the dataset from [here](https://drive.google.com/drive/folders/1aA--HjGDswTQ_ZdB4_ErIAOo88JergX9?usp=sharing).
3. Create a virtual environment using Python:
   ```bash
   python -m venv eyecare
   ```
4. Activate the virtual environment:
   ```bash
   env\Scripts\activate
   ```
5. Install the requirements:
   ```bash
   pip install -r Requirements.txt
   ```

### Mobile Development - Project Installation
*(Add detailed steps for mobile development installation here)*

### Cloud Computing - Backend Project Installation
*(Add detailed steps for cloud computing backend installation here)*

## How EyeCare Works
1. The EyeCare application functions by receiving input in the form of user images that show eye conditions such as cataracts, glaucoma, and others. 
2. The images can be in PNG, JPG, or JPEG format. 
3. Once the image is uploaded, the application predicts the eye condition using the eyecare.h5 model, which has been built with the pre-trained InceptionV3 algorithm.
4. The output generated is the predicted type of eye disease corresponding to the labels in the dataset: "Bulging_Eyes," "Cataracts," "Crossed_Eyes," "Glaucoma," "Normal_eyes," and "Uveitis." 
5. Based on the prediction, the system then provides recommendations for food, vitamins, and eye treatments.

## Project Scope
1. Input Data:

- The application accepts images for eye disease detection.
- Images must be in JPG format with a size of 224x224 pixels.
- Classification is limited to the specified types of eye diseases.

2. Eye Disease Classification:

- In the initial development phase, only a few classifications of eye diseases will be used.

3. Recommendations and No E-commerce System:

- The application provides recommendations for food, vitamins, and eye treatments.
- We do not provide an e-commerce system for the buying and selling of equipment or health products.

## Plans & Realization
To stay on track, the EyeCare team uses a Gantt Chart with the Agile methodology. We use EyeCare for weekly sprint discussions. Here is our Gantt Chart:

<a href="https://docs.google.com/spreadsheets/d/1Ctd2TDzmAwZdpHhR51sHbFc3sP_OoRfmCyJjpYqeANk/edit?gid=1115838130#gid=1115838130" title="EyeCare Timeline" target="_blank">EyeCare Timeline</a>

![Timeline](https://github.com/rangsikayana/eyecare-app/blob/dc8cdd1a7532695f12fa0d63c2928b3593c31dc3/assets/Gant%20chart.jpg)

![Trello](https://github.com/rangsikayana/eyecare-app/blob/80d4b19ab2347a87b342da96121edd3317dbdf2f/assets/Trello%20Kanban%20board.png)

## Bibliography

### A. Dataset
Our dataset can be found [here](https://github.com/rangsikayana/eyecare-app/tree/dc9c53006a620e5f5e1c13ba06122c0c854659fe/Dataset).

### B. Resources
Tools/IDE/Library and resources we used to build the app:
- **IDE:**
  - [![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)](https://code.visualstudio.com/)
  - [![Android Studio](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/studio?gclid=CjwKCAjwp6CkBhB_EiwAlQVyxRoFRkbXTQ0TrI0w-8LEwIttlMFbOnF-vTvc_e3dJFR55kiNIDo6nhoCMj8QAvD_BwE&gclsrc=aw.ds)
- **Library:**
  - Retrofit
  - [![TensorFlow](https://img.shields.io/badge/TensorFlow-%23FF6F00.svg?style=for-the-badge&logo=TensorFlow&logoColor=white)](https://www.tensorflow.org/)
- **Platform:**
  - [![Google Colab](https://img.shields.io/badge/Colab-F9AB00?style=for-the-badge&logo=googlecolab&color=525252)](https://colab.research.google.com/)
  - [![Google Cloud Platform](https://img.shields.io/badge/GoogleCloud-%234285F4.svg?style=for-the-badge&logo=google-cloud&logoColor=white)](https://cloud.google.com/)
  - [![Firebase](https://img.shields.io/badge/Firebase-039BE5?style=for-the-badge&logo=Firebase&logoColor=white)](https://firebase.google.com/)
  - [![Figma](https://img.shields.io/badge/figma-%23F24E1E.svg?style=for-the-badge&logo=figma&logoColor=white)](https://www.figma.com/)
- **API:**
  - Google APIs
- **Project Management:**
  - [![Discord](https://img.shields.io/badge/Discord-%235865F2.svg?style=for-the-badge&logo=discord&logoColor=white)](https://discord.com/)
  - [![Google Workspace](https://img.shields.io/badge/Google%20Drive-4285F4?style=for-the-badge&logo=googledrive&logoColor=white)](https://workspace.google.com/)
  - [![Trello](https://img.shields.io/badge/Trello-%23026AA7.svg?style=for-the-badge&logo=Trello&logoColor=white)](https://trello.com/)

### C. Academic Papers
- Amin, R., Ahmed, A., Hasan, S. S. U., & Akbar, H. (2022). Multiple Eye Disease Detection Using Deep Learning. *Foundation University Journal of Engineering and Applied Sciences*, 3(2), 14. [doi: 10.33897/fujeas.v3i2.689](https://doi.org/10.33897/fujeas.v3i2.689)

- Febrina, C., Mariyana, R., Kartika, I. R., Rezkiki, F., & Heliayanti, S. (2023). Menjaga Kesehatan Mata di Era Digitalisasi. *Empowering Society Journal*, 4(1), 29-36.

- Hubley, J., & Gilbert, C. (2006). Eye health promotion and the prevention of blindness in developing countries: critical issues. *British Journal of Ophthalmology*, 90(3), 279-284. [doi: 10.1136/bjo.2005.078451](https://doi.org/10.1136/bjo.2005.078451)

- Risnasari, R., Kusumawaty, S., & Anggara, A. (2020). Uveitis anterior dengan katarak komplikata. *Jurnal Medical Profession (MedPro)*, 2(3), 196. Palu, Indonesia: Faculty of Medicine, Universitas Tadulako.

- Widyandana, D., Prayogo, M. E., & Suhardjo. (2020). Eye disease early detection by primary health worker. *Journal of Community Empowerment for Health*, 3(3), 203-206. [doi: 10.22146/jcoemph.434181](https://doi.org/10.22146/jcoemph.434181)


## Presentation
The EyeCare final presentation can be found here:

<a href="https://docs.google.com/presentation/d/1SymhztUvO3dyTVISRKFlC7BjQb29CGKmPFE-cewOABw/edit?usp=sharingg" title="EyeCare Presentation" target="_blank">
    <img src="https://github.com/rangsikayana/eyecare-app/blob/0894535c616d5ec530503874adec350216a60435/assets/Final%20Deliverables.png" alt="Jernihin Presentation Video" style="width: 500px">
</a>

[Link Presentation](https://docs.google.com/presentation/d/1SymhztUvO3dyTVISRKFlC7BjQb29CGKmPFE-cewOABw/edit?usp=sharing)

## Demo Video
- [Link Demo](https://drive.google.com/file/d/1wqZuTUIM-V-rMjNXJTWoACc9HzFaasHt/view)
- [Link Youtube](https://bit.ly/Video-EyeCare)
