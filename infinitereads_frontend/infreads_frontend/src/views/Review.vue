<template>
  <v-form
    ref="form"
    class="ml-6 mr-6"
  > 
     <div class="font-italic">
    <h1>Reviews</h1>
  </div>
  <v-text-field
      v-model="title"
      label="Title"
      required
    ></v-text-field>
    <v-text-field
      v-model="username"
      label="Username"
      required
    ></v-text-field>



    <v-btn
      color="success"
      class="mr-4"
      @click="reviewByTitle"
    >
      Search By Book Title
    </v-btn>

    <v-btn
      color="yellow"
      class="mr-4"
      @click="reviewByUsername"
    >
      Search By User
    </v-btn>

          <v-btn
      color="purple"
      class="mr-4"
      @click="findAllBooks"
    >
      See Books
    </v-btn>
        <v-simple-table dense>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Id</th>
            <th class="text-left">Title</th>
            <th class="text-left">Author</th>
            <th class="text-left">ISBN</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in allBooks" :key="item.id">
            <td>{{ item.id }}</td>
            <td>{{ item.title}}</td>
            <td>{{ item.author }}</td>
            <td>{{ item.isbn }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>

<v-simple-table dense>
      <template v-slot:default>
        <thead>
          <tr>
            <th class="text-left">Id</th>
            <th class="text-left">Title</th>
            <th class="text-left">Author</th>
            <th class="text-left">ISBN</th>
            <th class="text-left">Rating</th>
            <th class="text-left">Review</th>
            <th class="text-left">By User</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in allReviews" :key="item.id">
            <td>{{ item.id }}</td>
            <td>{{ item.bookReviewed.title}}</td>
            <td>{{ item.bookReviewed.author }}</td>
            <td>{{ item.bookReviewed.isbn }}</td>
            <td>{{ item.rating }}</td>
            <td>{{ item.text}}</td>
            <td>{{ item.userAuthor.username }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>
      <v-text-field
      v-model="titleR"
      label="Title"
      required
    ></v-text-field>
    <v-text-field
      v-model="ratingR"
      label="Rate me"
      required
    ></v-text-field>
    
       <v-text-field
      v-model="textR"
      label="Review"
      required
    ></v-text-field>
    <v-btn
      color="error"
      class="mr-4"
      @click="writeReview"
    >
      Write Review!!1
    </v-btn>


  </v-form>
</template>

<script>
/* eslint-disable no-unused-vars */

  import axios from "axios";
  export default {
    name: 'ReviewView',
    data() {
      return {
         id:"",
         title:"",
         author:"",
         isbn:"",
         rating:"",
         text:"",
         username:"",
         allReviews: [],
         allBooks:[]
      }
    },
    methods: {
       async reviewByTitle() {
         try { 
          var resultReviews = await axios.get("http://localhost:8080/api/v1/review/title/"+this.title);
         //  window.localStorage.setItem("userId", result.data.id);
         console.log(resultReviews.data)
         this.allReviews = resultReviews.data;

         } catch (e) {
           alert("Could not find reviews!");
         }
       },
       async reviewByUsername() {
         try { 
          var resultReviews = await axios.get("http://localhost:8080/api/v1/review/userauthor/"+this.username);
         //  window.localStorage.setItem("userId", result.data.id);
         console.log(window.localStorage.getItem("userId"))
         this.allReviews = resultReviews.data;
          this.allReviews.sort((a,b)=>(b.rating-a.rating))
         } catch (e) {
           alert("Could not find reviews!");
         }
       },
       async writeReview() {
         try {  
              console.log(this.textR)
              console.log(parseFloat(this.ratingR))

          var book = await axios.get("http://localhost:8080/api/v1/book/"+this.titleR)
          var user= await axios.get("http://localhost:8080/api/v1/user/"+parseInt(window.localStorage.getItem("userId")))                  
          //if(book!==null||user!==null){
          var result = await axios.post("http://localhost:8080/api/v1/review/",{rating:parseFloat(this.ratingR),text:this.textR,userAuthor:user.data ,bookReviewed: book.data});
         //  window.localStorage.setItem("userId", result.data.id);

        
         console.log(result.data)
         // }

         } catch (e) {
           alert("Error writing review!");
         }
       },
           async findAllBooks() {
      try {
          var resultBooks = await axios.get("http://localhost:8080/api/v1/book");
          this.allBooks = resultBooks.data;
         // window.localStorage.setItem("id", books.data.id);
      } catch (e) {
          alert("Eroare");
      }
    }
    }
  }
  /* eslint-enable no-unused-vars */

</script>
