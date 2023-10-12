Implementing the APIs using the Third Party Client (Fake Store Api).

For the 26th Sept Lecture:

Work done till 1st Oct (Sunday):
1. Created client for FakeStoreApis.
2. De-coupled the FakeStoreProductServiceImpl with the RestTemplateBuilder.
3. Added Error Handling on ProductController by ExceptionAdvices.
4. Created a utility class 'ProductUtility' which has all the static methods for converting one entity to another.
5. Implemented Category Apis, similar to the implementation of Product Apis.

For the 3rd Oct Lecture:
1. Successfully connected the application with MySQL.
2. In MySQL, created a new user with a password and granted it the privileges.
3. Annotated the Models with @Entity
4. Annotated the BaseModel with @MappedSuperClass
5. For Primary Key, used @Id annotation.
6. To generate the PKs automatically, used @GeneratedValue annotation with Generation Type Identity
7. Created Repositories for the respective Models.

For 10th Oct Lecture:
1. Learned about EAGER and FETCH types
2. Learned about PERSIST Cascading Type. If a new product is being saved with a new category, that category
    also gets saved in the DB along with the new Product.
3. Learned about REMOVE Cascading Type. If removing a product, it also removes the associated category.