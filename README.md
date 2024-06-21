# EyeCare
See our wireframe <a href="https://www.figma.com/design/7yjvxqIIuj6zPrNkRZCxlJ/EyeCare-app?node-id=54795-2155&t=nxWxPQLLyFMWEk9I-0" title="Figma" target="_blank"><b>here</b></a>.

<br>

![EyeCare Prototype](https://github.com/rangsikayana/eyecare-app/blob/ff8f02165b7359798eec6621e14ff7bca3c1abf2/assets/EyeCare-Prototype.mp4)


# Table of Content

- [EyeCare](#eyecare)
- [Table of Content](#table-of-content)
- [About EyeCare](https://github.com/rangsikayana/eyecare-app/tree/main?tab=readme-ov-file#eyecare-your-personal-eye-health-companion)
  - [Our Team](#our-team)
  - [Goal \& Aim](#goal--aim)
  - [Installation \& Deployment](#installation--deployment)
    - [Machine Learning - Project Installation to Personal Virtual Environment](#machine-learning---project-installation-to-personal-virtual-environment)
    - [Deploy Machine Learning Model with Compute Engine on Google Cloud Platform](#deploy-machine-learning-model-with-cloudrun-on-google-cloud-platform)
    - [Mobile Development - Project Installation](#mobile-development---project-installation)
    - [Cloud Computing - Backend Project Installation](#cloud-computing---backend-project-installation)
  - [How EyeCare Works](#how-eyecare-works)
  - [Plans \& Realization](#plans--realization)
  - [Project Scope](#how-eyecare-works)
  - [Bibliography](#bibliography)
    - [A. Dataset](#a-dataset)
    - [B. Resources](#b-resources)
    - [C. Academic Papers](#c-academic-papers)
  - [Presentation](#presentation)
  - [Demo Video](#demo-video)

<br>

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
*(Explain the working of the EyeCare app here)*

## Project Scope
*(Define the scope of the project here)*

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
*(List any academic papers referenced or used in the project)*

## Presentation
The EyeCare final presentation can be found here:

<a href="https://docs.google.com/presentation/d/1SymhztUvO3dyTVISRKFlC7BjQb29CGKmPFE-cewOABw/edit?usp=sharingg" title="EyeCare Presentation" target="_blank">
    <img src="https://github.com/Nusatala/.github/assets/70735803/bc2a165c-a742-4dd6-96ca-361a59a73ed6" alt="Jernihin Presentation Video" style="width: 500px">
</a>

[Link Presentation](https://docs.google.com/presentation/d/1SymhztUvO3dyTVISRKFlC7BjQb29CGKmPFE-cewOABw/edit?usp=sharing)

## Demo Video
- [Link Demo](https://drive.google.com/file/d/1wqZuTUIM-V-rMjNXJTWoACc9HzFaasHt/view)
- [Link Youtube](https://bit.ly/Video-EyeCare)
