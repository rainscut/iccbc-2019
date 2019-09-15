# yangtao-python

This folder contains several utility scripts for the Yangtao Learning Hanzi Augmented Reality app.
Due to tensorflow, it has to use Python 3.6. 

Please refer to the respective files for more documentation.

## Requirements

    opencv-python
    tensorflow==2.0.0-rc0
    Pillow
    tqdm
    wget
    attrs
    
## Training the Hanzi classification model

1. Obtain the training data from the [South China University of Technology HCII Laboratory](http://www.hcii-lab.net/data/scutspcci/download.html) 
and put it into `data/external/sppci`.
2. To convert the data we just downloaded to png, run `yangtao/detection/convert_spcci.py`
3. To train the model, run `yangtao/detection/train_hog_model.py`. The resulting model can be found
   in `data/results/hog_model.h5`.
4. In order to convert the *Keras* model to a *tflite* model, run `convert_tflite.py` 
   or follow the [tflite conversion guide](https://www.tensorflow.org/lite/convert/python_api). 
5. Copy the resulting model and `data/results/labels.txt` to the Android apps' asset folder.