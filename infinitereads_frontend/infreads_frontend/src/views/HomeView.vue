<template>
  
  <v-form
    ref="form"
    class="ml-6 mr-6"
  >
   <div class="font-italic">
    <h1>Welcome to Infinite Reads, the place where we brag about books we haven't read!</h1>
  </div>
      <v-btn
      color="success"
      class="mr-4"
      @click="$router.push({ name: 'login' })"
    >
      Login
    </v-btn>

    <v-btn
      color="error"
      class="mr-4"
      @click="$router.push({ name: 'register' })"
    >
      Register
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

  </v-form>

</template>

<script>
 // import HelloWorld from '../components/HelloWorld'
  import axios from "axios";
  export default {
    name: 'HomeView',

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
</script>
