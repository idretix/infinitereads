<template>
  <v-form
    ref="form"
    class="ml-8 mr-6"
  >
       <div class="font-italic">
    <h1>Admin's Room</h1>
  </div>
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
      <v-btn
      color="purple"
      class="mr-4"
      @click="findAllBooks"
    >
      See Books
    </v-btn>
    <v-text-field
      v-model="id"
      label="Id of book to delete"
      required
    ></v-text-field>



    <v-btn
      color="red"
      class="mr-4"
     
      @click="deleteB"
    >
      Delete
    </v-btn>

    <v-text-field
      v-model="idU"
      label="IdU of book"
      required
    ></v-text-field>

    <v-text-field
      v-model="title"
      label="New title of book"
      required
    ></v-text-field>
    <v-text-field
      v-model="author"
      label="New author of book"
      required
    ></v-text-field>
     <v-text-field
      v-model="isbn"
      label="New ISBN of book"
      required
    ></v-text-field>

    <v-btn
      color="gray"
      class="mr-4"
     
      @click="updateB"
    >
      Update
    </v-btn>

  
    <v-text-field
      v-model="titleA"
      label="New title of book"
    ></v-text-field>
    <v-text-field
      v-model="authorA"
      label="New author of book"
    ></v-text-field>
     <v-text-field
      v-model="isbnA"
      label="New ISBN of book"
    ></v-text-field>

    <v-btn
      color="pink"
      class="mr-4"
     
      @click="addB"
    >
      Add
    </v-btn>
  </v-form>
</template>

<script>
  import axios from "axios";
  export default {
    name: 'BookManage',
    data() {
       return {
      id:"",
      title:"",
      author:"",
      isbn:"",
      allBooks: [],
      }
    },
     methods: {
      async deleteB() {
        try { 
          /* eslint-disable no-unused-vars */

          //var result = 
          await axios.delete("http://localhost:8080/api/v1/book/"+this.id, { id:this.id});
          /* eslint-enable no-unused-vars */

         // this.$router.push({ name: 'login' });
        } catch (e) {
          /*empty*/
        }
      },
     async updateB() {
        try { 
           /* eslint-disable no-unused-vars */

         // var result =
           await axios.put("http://localhost:8080/api/v1/book", { id:this.idU,author:this.author,title:this.title,isbn:this.isbn});
            /* eslint-enable no-unused-vars */

         // this.$router.push({ name: 'login' });
        } catch (e) {
          /*empty*/
        }
      },
          async addB() {
        try { 

                     /* eslint-disable no-unused-vars */

         // var result = 
         if(this.titleA!=null)
         {
           if(this.authorA==null)
           authorA="Anonymous";
             await axios.post("http://localhost:8080/api/v1/book", {author:this.authorA,title:this.titleA,isbn:this.isbnA});

         }
                    /* eslint-enable no-unused-vars */

        // this.$router.push({ name: 'login' });
        } catch (e) {
          /*empty*/
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
        //

    }
  }
</script>




