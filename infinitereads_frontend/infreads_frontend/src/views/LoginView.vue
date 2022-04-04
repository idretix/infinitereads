<template>
  <v-form
    ref="form"
    class="ml-6 mr-6"
  >
    <v-text-field
      v-model="username"
      label="Userame"
      required
    ></v-text-field>

    <v-text-field
      v-model="password"
      label="Password"
      type="password"
      required
    ></v-text-field>

    <v-btn
      color="success"
      class="mr-4"
      @click="login"
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
  </v-form>
</template>

<script>
/* eslint-disable no-unused-vars */

  import axios from "axios";
  export default {
    name: 'LoginView',
    data() {
      return {
        username: "",
        password: ""
      }
    },
    methods: {
    //   async login() {
    //     try { 
    //       var result = await axios.post("http://localhost:3000/cats/login", { name: this.name, password: this.password });
    //       window.localStorage.setItem("catId", result.data.id);
    //       this.$router.push({ name: 'home' });
    //     } catch (e) {
    //       alert("Credentiale incorecte!");
    //     }
    //   }
    }
  }
  /* eslint-enable no-unused-vars */

</script>
