<template>
  <v-form
    ref="form"
    class="ml-6 mr-6"
  > 
     <div class="font-italic">
    <h1>My Top</h1>
  </div>

    <v-btn
      color="success"
      class="mr-4"
      @click="getTop"
    >
      Get My Top
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
            <th class="text-left">Tier</th>
            <th class="text-left">Title</th>
            <th class="text-left">Author</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in allTop" :key="item.tier">
            <td>{{ item.tier }}</td>
            <td>{{ item.book.title}}</td>
            <td>{{ item.book.author }}</td>
          </tr>
        </tbody>
      </template>
    </v-simple-table>

      <v-text-field
      v-model="title"
      label="Title"
      required
    ></v-text-field>
    <v-text-field
      v-model="tier"
      label="Tier"
      required
    ></v-text-field>

    <v-btn
      color="error"
      class="mr-4"
      @click="writeTopEntry"
    >
      Enter Top Entry
    </v-btn>


  </v-form>
</template>

<script>
/* eslint-disable no-unused-vars */

  import axios from "axios";
  export default {
    name: 'Top',
    data() {
      return {
         id:"",
         title:"",
         author:"",
         tier:"",
         username:"",
         allTop:[],
         allBooks:[]
      }
    },
    methods: {
       async getTop() {
         try { 
          var resultTop = await axios.get("http://localhost:8080/api/v1/top/username/"+(window.localStorage.getItem("username")));
         //  window.localStorage.setItem("userId", result.data.id);
         console.log(resultTop.data.id)
         this.allTop=resultTop.data;
         this.allTop.sort((a,b)=>(a.tier-b.tier))
         console.log(this.allTop)

         } catch (e) {
           alert("Could not find top entries!");
         }
       },
       async writeTopEntry() {
         try {  

          var book = await axios.get("http://localhost:8080/api/v1/book/"+this.title)
          var user= await axios.get("http://localhost:8080/api/v1/user/"+parseInt(window.localStorage.getItem("userId")))                  
          //if(book!==null||user!==null){
          var result = await axios.post("http://localhost:8080/api/v1/top/",{tier:parseInt(this.tier),userAuthor:user.data ,book: book.data});
         //  window.localStorage.setItem("userId", result.data.id);

        
         console.log(result.data)
         // }

         } catch (e) {
           alert("Error writing top entry!");
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
