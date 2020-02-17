# Markdown tutorial
0. **[Markdown tutorial](https://www.youtube.com/watch?v=HUBNt18RFbo)**

*This text* is italic 

_This text_ is also italic

__This text__ is bold
<!-- Strikethrough -->
~~This text~~ is strikethrough

<!-- Horizontal rule -->
---
___

<!-- Block quote -->
> This is a quote

<!-- Links -->
[Android examples](https://github.com/lvtute/Android-Examples)

<!-- UL -->
* item 1
* item 2
* item 3
  * nested item 1
  * nested item 2

<!-- Inline code block -->
`<p>This is a paragraph</p>`

<!-- Image -->
![Google logo](https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png)

<!-- Code blocks -->
```
  npm install
  npm start
```

```javascript
  function add(num1, num2){
    return num1+num2;
  }
```

<!-- Task lists -->
* [x] Task 1
* [x] Task 2
* [] Task 3


---
___
# Main part- Android examples
## 1. **What'stheweather**
  * Set background with image /// Get JSON from openweathermap.org /// Get data in background using Asynctask and InputStream and InputStreamReader. 

  
![image](https://user-images.githubusercontent.com/16172615/73701569-8a1c7a80-471c-11ea-9436-18eb4f488cba.png)

## 2. **Map and location demo**
  * App features:
 
    * [x] Tracking user's position and show on map.
   
  * Techniques used:
    
    * [x] Checking user device SDK version
    * [x] LocationManager
    * [x] LocationListener
    * [x] mMap.addMarker
    * [x] LatLng userLocation = new LatLng(location.getLatitude(), location.getLongitude());
    
  ![image](https://user-images.githubusercontent.com/16172615/74205687-fb26d980-4caa-11ea-82d7-e25bfa0ad8ed.png)


  ## 3. **Hikers's watch**
  * Background image was got from 
  [unsplash.com](https://unsplash.com/)
  * App features:
      * [x] Show device latitude
      * [x] Show device longtitude
      * [x] Show device laltitude
      * [x] Show device address
  * New techniques used:
      * [x] Geocoder

  * Image:

![image](https://user-images.githubusercontent.com/16172615/74294133-97b2af80-4d6f-11ea-8cc6-d6b18563eac4.png)

## 4. **Menu demo**
* App features:
  * [x] Create a menu of options on the action bar
* New techniques used:
  * [x] onCreateOptionsMenu();
  * [x] onOptionsItemSelected();
  * [x] MenuInflater.inflate();
  
* Image:

![image](https://user-images.githubusercontent.com/16172615/74557503-dc6a6080-4f92-11ea-9fbf-50d36af772e3.png) ![image](https://user-images.githubusercontent.com/16172615/74557576-00c63d00-4f93-11ea-93af-bbd5a49a19db.png)

## 5. **Menu demo**
* App features:
  * [x] Ask user to choose a language and save it to shared preferences. If there is saved language, then load it and doesn't ask again.
* New techniques used:
  * [x] Alert dialog
  
* Image:

![image](https://user-images.githubusercontent.com/16172615/74563445-64566780-4f9f-11ea-9046-e81c069d8f9d.png)
![image](https://user-images.githubusercontent.com/16172615/74563489-7e904580-4f9f-11ea-9166-2026017e23cc.png)

## 5. **Notes**
* App features:
  * [x] Add new note
  * [x] Edit note
  * [x] Delete note
  * [x] Save/Load note with shared preferences.
* New techniques used:
  * [x] Save Set<String> to shared preferences.
  * [x] Set text changed listener for edittext.
  
* Image:

![image](https://user-images.githubusercontent.com/16172615/74575969-a2fa1b00-4fbb-11ea-88f9-3e004023be75.png)
![image](https://user-images.githubusercontent.com/16172615/74575999-b9a07200-4fbb-11ea-8bd9-b17436fa1635.png)
![image](https://user-images.githubusercontent.com/16172615/74576011-c624ca80-4fbb-11ea-9ec1-e24ee6835681.png)
![image](https://user-images.githubusercontent.com/16172615/74576029-d341b980-4fbb-11ea-9ffd-49ec7d83968b.png)
![image](https://user-images.githubusercontent.com/16172615/74576040-e18fd580-4fbb-11ea-98f3-a5414de2d087.png)


## 6. **SQLite demo**
* App features:
  * [x] Create database
  * [x] Insert recode
  * [x] Create/ query cursor