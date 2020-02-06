## Instalasi

# Create Project Android

- Project Android Empty Activity : limakel3
- Package : com.sttnf.limakel3
- Language : Java
- API 21: Android 5.0 (Lolipop)

# Import Library

- Ubah file Gradle Scripts/build.gradle (Module: app)
```
implementation 'com.google.android.material:material:1.0.0'
implementation 'androidx.recyclerview:recyclerview:1.1.0'
implementation 'androidx.cardview:cardview:1.0.0'
implementation 'com.squareup.retrofit2:retrofit:2.4.0'
implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
implementation 'com.thebluealliance:spectrum:0.7.1'
```

# 

# Connect Mysql

- Buat file limakel3/connect.php
```
<?php

$conn = mysqli_connect("localhost", "root", "", "limakel3");

/*
if($conn){
	echo "Berhasil";
}else{
	echo "Gagal";
}
*/

?>
```

- Buat file limakel3/project.php

```
<?php

header("Content-type:application/json");

require_once("connect.php");

$query = mysqli_query($conn, "select * from project");

$response = array();

while($row = mysqli_fetch_assoc($query)){
	array_push($response,
	array(
		'id'			=> $row['id'],
		'nama'			=> $row['nama'],
		'deskripsi'		=> $row['deskripsi'],
		'tanggal_mulai'		=> $row['tanggal_mulai'],
		'tanggal_akhir'		=> $row['tanggal_akhir'],
		'jumlah_sprint'		=> $row['jumlah_sprint'],
		'budget'		=> $row['budget'],
		'status'		=> $row['status'],
		'persen'		=> $row['persen'],
		'semester_id'		=> $row['semester_id'],
		'scrummaster_id'	=> $row['scrummaster_id'],
		'tim_id'		=> $row['tim_id'],
		'created_by'		=> $row['created_by'],
		'created_at'		=> $row['created_at'],
		'updated_at'		=> $row['updated_at'],
	));
}

echo json_encode($response);

?>
```

# Theme

- Ubah file res/drawable/values/styles.xml
```
<!-- Base application theme. -->
    <style name="EditorTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorAccent</item>
        <item name="colorPrimaryDark">@color/colorAccent</item>
        <item name="colorAccent">@color/colorPrimaryDark</item>
    </style>
```

# MVP

- Buat folder app/java/com.sttnf.limakel3/activity/editor/
- Buat folder app/java/com.sttnf.limakel3/activity/main/
- Buat folder app/java/com.sttnf.limakel3/api/
- Buat folder app/java/com.sttnf.limakel3/model/

## Backend

# Manifests Done
# ApiClient Done
# ApiInterface Done
# Project Done
# MainActivity
# MainAdapter
# MainPresenter
# MainView
# EditorActivity
# EditorPresenter
# EditorView

## Frontend
