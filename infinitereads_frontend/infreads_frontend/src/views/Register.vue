<template>
  <v-form
    ref="form"
    class="ml-8 mr-6"
  >
       <div class="font-italic">
    <h1>Register</h1>
  </div>
    <v-text-field
      v-model="username"
      label="Username"
      required
    ></v-text-field>

    <v-text-field
      v-model="email"
      label="E-Mail"
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
      @click="register"
    >
      Register
    </v-btn>
  </v-form>
</template>

<script>
  import axios from "axios";
  export default {
    name: 'RegisterView',
    data() {
       return {
        username: "",
        email: "",
        password: ""
      }
    },
     methods: {
      async register() {
        try { 
          /* eslint-disable no-unused-vars */

          var result = await axios.post("http://localhost:8080/api/v1/user", { username: this.username, email: this.email, password: this.password});
         /* eslint-enable no-unused-vars */

         this.$router.push({ name: 'login' });
        } catch (e) {
          /*empty*/
        }
      }
    }
  }
</script>