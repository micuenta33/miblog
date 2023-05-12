 tinymce.init({
         selector: 'textarea',
         plugins: 'image link',
         toolbar: 'undo redo | formatselect | bold italic underline | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
         image_uploadtab: true,
         image_title: true,
         automatic_uploads: true,
         file_picker_types: 'image',
         file_picker_callback: function (callback, value, meta) {
             if (meta.filetype === 'image') {
                 var input = document.createElement('input');
                 input.setAttribute('type', 'file');
                 input.setAttribute('accept', 'image/*');
                 input.onchange = function () {
                     var file = this.files[0];
                     var reader = new FileReader();
                     reader.onload = function () {
                         var id = 'blobid' + (new Date()).getTime();
                         var blobCache = tinymce.activeEditor.editorUpload.blobCache;
                         var base64 = reader.result.split(',')[1];
                         var blobInfo = blobCache.create(id, file, base64);
                         callback(blobInfo.blobUri(), { title: file.name });
                     };
                     reader.readAsDataURL(file);
                 };
                 input.click();
             }
         }
     });
