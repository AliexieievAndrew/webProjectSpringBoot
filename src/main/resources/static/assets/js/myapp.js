$(function () {

   switch (menu) {
       case 'About':
           $('#about').addClass('active');
           break;
       case 'Contact':
           $('#contact').addClass('active');
           break;
       case 'All Products':
           $('#allproducts').addClass('active');
           break;
       case 'Manage Products':
           $('#manageproducts').addClass('active');
           break;
       case 'Cart':
           $('#cart').addClass('active');
           break;
       default:
           $('#home').addClass('active');
           $('#a_'+menu).addClass('active');
           break;
   }

   // using char $ - because indicating in jquery element
    // productListTable - id Data Tables object in the allproducts.ftl
   var $table = $('#productListTable');

   // execute the below code only where we have this table
    if($table.length) {
        // console.log('test string in console');

        // getting JSON url for dataTable
        // if categoryId = '' will show all products category else - products by category id
        var jsonUrl = '';
        if(window.categoryId == '') {
            jsonUrl = window.contextRoot + '/json/data/all/products';
        } else{
            jsonUrl = window.contextRoot + '/json/data/category/'+ window.categoryId +'/products';
        }
        $table.DataTable({

            // configure show expandable list
            lengthMenu: [[3,5,10,-1],["3 products","5 products","10 products","all products"]],
            pageLength: 5, // default
            // data: products // for testing
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                // name of the date: according to the structure JSON/dto objects 'Category'
                {
                    data: 'code',
                    mRender: function (data,type,row) {
                        return '<img ' +
                            //loading static resources
                            'src ="' + window.contextRoot +'/assets/images/'+ data +'.jpg" ' +
                            // to get little (custom) size
                            'style="width:100px;height:100px;"/>'
                        console.log(window.contextRoot +'/assets/images/'+ data);
                    }
                },
                {
                    data: 'name'
                },
                {
                    data: 'description',
                    bSortable: false
                },
                {
                    data: 'unitPrice',
                    mRender: function (data,type,row) {
                        return data + ' UAH';
                    }
                },
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data,type,row) {
                        var str = '';

                        // here added buttons icons(eye and cart icon)
                        str += '<a href="' + window.contextRoot + '/show/'+data+'/product" ' +
                            'class="btn btn-primary">' +
                            '<span class="fas fa-eye"></span>' +
                            '</a> &#160;'; // &#160; gives space between elements

                        str += '<a href ="' + window.contextRoot + '/cart/add/'+data+'/product" ' +
                            'class="btn btn-success">' +
                            '<span class="fas fa-shopping-cart"></span>' +
                            '</a>';

                        return str;
                    }
                }
            ]
        });
    }

    // dismissing alert after 3 seconds
    var $alert = $('.alert');
    if ($alert.length){
        setTimeout(function() {
            $alert.fadeOut('slow');
        },3000)
    }

    /*
     * DataTable for admin
     */

    var $adminProductsTable = $('#adminProductsTable');
        var jsonUrl = window.contextRoot + "/json/data/admin/all/products";

        $adminProductsTable.DataTable ({
            lengthMenu: [[3,5,10,-1],["3 products","5 products","10 products","all products"]],
            pageLength: 5, // default
            ajax: {
                url: jsonUrl,
                dataSrc: ''
            },
            columns: [
                // column id
                {
                    data: 'id'
                },
                //column image (using code)
                {
                    data: 'code',
                    bSortable: false,
                    mRender: function (data,type,row) {
                        return '<img ' +
                            //loading static resources
                            'src ="' + window.contextRoot +'/assets/images/'+ data +'.jpg" ' +
                            // to get little (custom) size
                            'style="width:50px;height:50px;"/>'
                    }
                },
                //column name
                {
                    data: 'name'
                },
                // column description
                {
                    data: 'description',
                    bSortable: false
                },
                // column price
                {
                    data: 'unitPrice',
                    mRender: function (data,type,row) {
                        return data + ' UAH';
                    }
                },
                // column active
                {
                    data: 'active',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';

                        if (data){
                            // testing
                            str += '<label class="checkbox">';
                            str += '<input type="checkbox" checked = "checked" value="' + row.id + '"/>';
                            str += '<div class = "checkbox__text"/>';
                            str += '</label>';


                            // str += '<input type="checkbox" name = "'+ row.id +'" class="checkbox" id="'+ row.id +'" checked = "checked" value="'+ row.id +'"/>';
                        } else {

                            // testing
                            str += '<label class="checkbox">';
                            str += '<input type="checkbox" value="' + row.id + '"/>';
                            str += '<div class = "checkbox__text"/>';
                            str += '</label>';


                            // str += '<input type="checkbox" name = "'+ row.id +'" class="checkbox" id="'+ row.id +'" checked = "" value="'+ row.id +'"/>';
                        }
                        return str;
                    }
                },
                // column edit
                {
                    data: 'id',
                    bSortable: false,
                    mRender: function (data, type, row) {
                        var str = '';
                        str += '<a href="'+window.contextRoot+'/manage/'+ data +'/product" class="btn btn-warning">'
                        str += '<span class="fas fa-edit"/>\n';
                        str += '</a>';
                        return str;
                    }
                }
            ],
            // initComplete must be used !!!
            // activation and deactivation product
            initComplete: function() {
                var api = this.api();
                console.log('test string in console');
                api.$('.checkbox input').on('change',function(){
                    var checkbox = $(this);
                    var value = checkbox.prop('value');

                    var activationUrl = window.contextRoot + '/manage/product/'+ value + '/activation';
                    $.post(activationUrl);
                });
            }
        });


    // --------------- jQuery Validation Code
    //methods required for validation
    function errorPlacement(error, element) {
        // Add the 'help-block' class to the error element
        error.addClass("help-block");

        // add the error label after the input element
        error.insertAfter(element);


        // add the has-feedback class to the
        // parent div.validate in order to add icons to inputs
        element.parents(".validate").addClass("has-feedback");

    }

    // --------------- validation code for the loginForm
    var $loginForm = $('#loginForm');
    if($loginForm.length){
        console.log('inside login form');
        $loginForm.validate({
            rules: {
                username: {
                    required: true,
                    email: true
                },
                password: {
                    required:true
                }
            },
            messages: {
                username: {
                    required: 'please enter email',
                    email: 'please enter valid email'
                },
                password: {
                    required: 'please enter the password'
                }
            },
            errorElement : "em",
            errorPlacement : function(error, element) {
                // Add the 'help-block' class to the error element
                error.addClass("help-block");

                // add the error label after the input element
                error.insertAfter(element);
            }
        });
    }


    //    on click product count
    //    https://stackoverflow.com/questions/4323848/how-to-handle-button-click-events-in-jquery
    //-----------------------------------
    $('button[name="refreshCart"]').click(function () {
    //   get cartLine id
        var cartLineId = $(this).attr('value');

    //  get count from <input> id = "count_${cartLine.id}"
        var countProduct = $('#count_' + cartLineId);

    //  get true count from <input> value = "${cartLine.productCount}"
        var trueCount = countProduct.attr('value');
        var currentCount = countProduct.val();

        // work only when count was changed
        if(currentCount !== trueCount){
            console.log("current count: " + currentCount);
            console.log("true count: " + trueCount);
            if(trueCount < 1 || trueCount > 20) {
                countProduct.val(trueCount);
            }else {
                var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
                // go to link
                window.location.href = updateUrl;
            }
        }
    });
    //-----------------------------------
});