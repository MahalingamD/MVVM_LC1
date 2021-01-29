package com.enflac.myapplication.utils

import java.io.IOException

class APIException(message:String) :Exception(message)
class InternetException(message:String) :IOException(message)
