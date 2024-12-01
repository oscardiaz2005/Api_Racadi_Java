package com.Racadi.Academy.Racadi_Academy.Servicios;

import com.Racadi.Academy.Racadi_Academy.Entidades.Clase;
import com.Racadi.Academy.Racadi_Academy.Entidades.Reserva;
import com.Racadi.Academy.Racadi_Academy.Repositorios.ClaseRepositorio;
import com.Racadi.Academy.Racadi_Academy.Repositorios.ProfesorRepositorio;
import com.Racadi.Academy.Racadi_Academy.Repositorios.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ClaseServicio {
    @Autowired
    private ClaseRepositorio claseRepositorio;

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    private final ProfesorRepositorio profesorRepositorio;

    public ClaseServicio(ClaseRepositorio claseRepositorio, ProfesorRepositorio profesorRepositorio) {
        this.claseRepositorio = claseRepositorio;
        this.profesorRepositorio = profesorRepositorio;
    }

    public void añadirClase(Clase datosClase) {
        // Convertir hora_inicio y hora_fin
        LocalTime horaInicio = convertirHora(String.valueOf(datosClase.getHora_inicio()));
        LocalTime horaFin = convertirHora(String.valueOf(datosClase.getHora_fin()));

        // Validaciones
        validarFecha(datosClase.getFecha());
        validarHoras(horaInicio, horaFin);
        validarHorariosDisponibles(horaInicio);
        validarClasesDuplicadas(datosClase);
        validarConflictosProfesor(datosClase.getDocumentoProfesor(), datosClase.getFecha(), horaInicio);
        validarProfesor(datosClase.getDocumentoProfesor());
        verificarCupos(datosClase.getCupos());

        // Crear nueva clase
        Clase nuevaClase = new Clase();
        nuevaClase.setSede(datosClase.getSede());
        nuevaClase.setNivel(datosClase.getNivel());
        nuevaClase.setHora_inicio(horaInicio);
        nuevaClase.setHora_fin(horaFin);
        nuevaClase.setFecha(datosClase.getFecha());
        nuevaClase.setDocumentoProfesor(datosClase.getDocumentoProfesor());
        nuevaClase.setCupos(datosClase.getCupos());

        // Guardar clase en la base de datos
        claseRepositorio.save(nuevaClase);
    }

    private LocalTime convertirHora(String hora) {
        try {
            return LocalTime.parse(hora);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de hora no válido. Use HH:mm.");
        }
    }

    private void validarFecha(LocalDate fecha) {
        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser anterior a la actual.");
        }
    }

    private void validarHoras(LocalTime horaInicio, LocalTime horaFin) {
        if (horaInicio.isAfter(horaFin)) {
            throw new IllegalArgumentException("La hora de inicio debe ser anterior a la hora de fin.");
        }
    }

    private void validarHorariosDisponibles(LocalTime horaInicio) {
        // Implementar validación según lógica de horarios
    }

    private void validarClasesDuplicadas(Clase datosClase) {
        // Implementar lógica para validar clases duplicadas
    }

    private void validarConflictosProfesor(String documentoProfesor, LocalDate fecha, LocalTime horaInicio) {
        // Implementar lógica para validar conflictos de horarios
    }

    private void validarProfesor(String documentoProfesor) {
        if (!profesorRepositorio.existsById(documentoProfesor)) {
            throw new IllegalArgumentException("El profesor no existe.");
        }
    }

    private void verificarCupos(int cupos) {
        if (cupos < 1 || cupos > 15) {
            throw new IllegalArgumentException("Cupos inválidos, rango aceptado de 1 a 15.");
        }
    }


    public List<Clase> obtenerClasesEstudiante(String sede, String nivel) {
        return claseRepositorio.findBySedeAndNivel(sede, nivel);
    }

    public String cancelarReserva(Long idClase, String documentoEstudiante) {
        Optional<Clase> claseOpt = claseRepositorio.findById(idClase);
        if (!claseOpt.isPresent()) {
            throw new IllegalArgumentException("Clase no encontrada");
        }

        Clase clase = claseOpt.get();

        LocalDateTime horaInicioClase = LocalDateTime.of(clase.getFecha(), clase.getHora_inicio());
        LocalDateTime ahora = LocalDateTime.now();

        if (ChronoUnit.HOURS.between(ahora, horaInicioClase) < 2) {
            throw new IllegalArgumentException("No se puede cancelar con menos de 2 horas de antelación");
        }

        Optional<Reserva> reservaOpt = reservaRepositorio.findByIdClaseAndDocumentoEstudiante(idClase, documentoEstudiante);
        if (!reservaOpt.isPresent()) {
            throw new IllegalArgumentException("Reserva no encontrada");
        }

        try {
            Reserva reserva = reservaOpt.get();
            reservaRepositorio.delete(reserva);

            // Aumentar los cupos disponibles de la clase
            clase.setCupos(clase.getCupos() + 1);
            claseRepositorio.save(clase);

            return "Reserva cancelada exitosamente";
        } catch (Exception e) {
            throw new RuntimeException("Algo salió mal: " + e.getMessage());
        }
    }
}
