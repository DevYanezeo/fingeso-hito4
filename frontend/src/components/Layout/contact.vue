<template>
    <div class= "contact">
        <h1> Contáctanos </h1>
        <div class = 'contact-contents'>
            <div class="contact-info">
                <h2> SERVICIO AL CLIENTE</h2>
                <h3> Call Center: </h3>
                <div class = 'phone-num-01'>
                    <h4>+56 2 1234 5678</h4>
                </div>
                <p> Horario de atención Lunes a Viernes: 8:00 a 20:00</p>
                <p> Fines de semana y festivos: 10:00 a 16:00</p>
                <hr class="divider">
                <div class = 'phone-num-02'>
                    <h4 >+56 2 1122 5678</h4>
                </div>
                <p> Horario de atención Lunes a Viernes: 8:00 a 20:00</p>
                <p> Fines de semana y festivos: 10:00 a 16:00</p>
                <hr class="divider">
                <h4> Correo de contacto: </h4>
                <div class = 'contact-mail'>
                    <h5>AutoRentasChile@gmail.com</h5>
                </div>
                <p> Procura incluir nombre, rut y especificar el problema con el que necesitas ayuda.</p>
            </div>
            <div class="form-contact">
                <h2>FORMULARIO DE CONTACTO</h2>
                <form class="contact-form">
                    <!-- Falta? Captcha, y opcionalmente, permitirle al usuario seleccionar razon de consulta -->
                    <label for="name">Nombre:</label>
                    <input type="text" id="name" name="name" placeholder="Tu nombre" required>

                    <label for="rut">Rut:</label>
                    <input type="text" id="rut" name="rut" placeholder="Tu rut o pasaporte" required>
            
                    <label for="email">Correo Electrónico:</label>
                    <input type="email" id="email" name="email" placeholder="Tu correo" required>
            
                    <label for="message">Mensaje:</label>
                    <textarea id="message" name="message" rows="4" placeholder="Escribe tu duda aquí" required></textarea>
            
                    <button type="submit">Enviar</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>

</script>

<style scoped>

.contact{
    display: flex;
    justify-content: center;
    flex-direction: column;
    height: auto;
}

.contact h1{
    display: flex;
    justify-content: center;
    font-size: 40px;
}

.contact-contents{
    display: flex;
    flex-direction: row;
}

.contact-info{
    display: flex;
    flex-direction: column;
    border: 1px solid #010101;
    border-radius: 5px;
    width: 40%;
    margin: 20px;
    padding: 20px;
}

.form-contact{
    display: flex;
    flex-direction: column;
    border: 1px solid #010101;
    border-radius: 5px;
    width: 40%;
    margin: 20px;
    padding: 20px;
}

.contact-info h2{
    display: flex;
    justify-content: center;
}

.contact-info p{
    display: flex;
}

.form-contact{
    display:flex;
    border-radius: 5px;
    width: 40%;
    margin: 20px;
    padding: 20px;
}

.form-contact h2{
    display: flex;
    justify-content: center;
    margin: 20px;
    padding: 20px;
}

.phone-num-01, .phone-num-02, .contact-mail {
    display: flex;
    justify-content: center;
}

/*Barra divisora*/
.divider {
  border: none;
  height: 1px;
  background-color: #ccc;
  margin: 5px 0;
  width: 100%;
}

.contact-form label,
.contact-form input,
.contact-form textarea {
    font-family: 'Arial', sans-serif; /* Asegura que todos tengan la misma fuente */
    font-size: 1rem;
}

.contact-form label {
    font-weight: bold;
    margin-bottom: 5px; /* Espacio entre el label y el input */
}

.contact-form input,
.contact-form textarea {
    padding: 10px; /* Espacio interno */
    border: 1px solid #ccc; /* Borde para inputs */
    border-radius: 5px; /* Bordes redondeados */
    width: 100%; /* Asegura que ocupe el ancho del formulario */
    box-sizing: border-box; /* Ajusta el tamaño total */
}

.contact-form textarea {
    resize: none; /* Evita que el usuario cambie el tamaño */
}

.contact-form button {
    padding: 10px;
    font-size: 1rem;
    color: white;
    background-color: #007BFF; /* Color azul */
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.contact-form button:hover {
    background-color: #0056b3; /* Cambia el color al pasar el mouse */
}

/* Ajustes específicos para los tamaños de los headers */
.contact-info h4, .contact-info h5 {
    font-size: 1.25rem; /* Ajusta el tamaño según tus necesidades */
}

</style>

