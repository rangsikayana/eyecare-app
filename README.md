# Eye Disease Detection Project

## Overview

This project aims to develop a deep learning model to classify different eye diseases from images. Using transfer learning techniques and a combination of datasets from Kaggle and Roboflow, we built, trained, and evaluated a convolutional neural network (CNN) model to identify six types of eye conditions.

## Project Steps

### Data Collection and Cleansing

#### Kaggle Dataset

We downloaded a comprehensive eye disease dataset from Kaggle using the Kaggle API. This dataset provided a solid foundation with high-quality, labeled images.

#### Roboflow Dataset

To enhance the diversity and robustness of our training data, we integrated an additional dataset from Roboflow, ensuring a more comprehensive coverage of eye disease images.

#### Web Scraping

Supplementary data collection was performed through web scraping from Google Images. This approach ensured a diverse set of images representing various eye conditions, further enriching our dataset.

#### Data Cleansing

The collected images were meticulously cleansed to remove any irrelevant or poor-quality images. This step was crucial for ensuring the accuracy and reliability of the dataset.

#### Data Resizing

To standardize the dataset, all images were resized to 224x224 pixels. This consistency is vital for effective model training and evaluation.

### Data Details

The dataset includes images of the following eye conditions:

- **Bulging_Eyes:** 206 images
- **Cataracts:** 184 images
- **Crossed_Eyes:** 184 images
- **Glaucoma:** 200 images
- **Normal_Eyes:** 202 images
- **Uveitis:** 201 images

### Model Building and Tuning

#### Custom Model

A custom model architecture was designed and tailored to our specific dataset. This bespoke approach allowed for flexibility and optimization based on the unique characteristics of the data.

#### InceptionV3-Based Model

We leveraged the InceptionV3 model pre-trained on ImageNet, which provided a robust starting point. Custom layers were added for our specific classification task, and the base model's layers were frozen to retain the pre-trained features.

#### Model Training

The model was trained using early stopping and learning rate reduction techniques to prevent overfitting and optimize performance. The training process, conducted over 100 epochs, was monitored using validation loss and accuracy metrics, ensuring the model's robustness and generalizability.

#### Model Saving

The trained model was saved in both .h5 and .keras formats, facilitating easy loading for future predictions or further training. This dual-format saving ensures compatibility and flexibility for various applications.

#### Convert Model to TensorFlow.js

To make the model accessible via web applications, it was converted to TensorFlow.js format. This allows the model to run directly in the browser, enabling real-time predictions without the need for server-side computations.


## Conclusion

This project successfully demonstrates the use of deep learning and transfer learning techniques for eye disease classification. The model can accurately identify six different eye conditions, which can assist in early diagnosis and treatment planning. The combination of robust data preprocessing, augmentation, and careful model tuning contributed to the project's success.
