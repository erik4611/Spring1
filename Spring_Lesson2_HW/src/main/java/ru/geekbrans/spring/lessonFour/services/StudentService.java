package ru.geekbrans.spring.lessonFour.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.geekbrans.spring.lessonFour.model.Student;
import ru.geekbrans.spring.lessonFour.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findOneById(Long id) {
        return studentRepository.findOneById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public double getAverageScore() {
        return studentRepository.findAll().stream().mapToInt(Student::getScore).average().getAsDouble();
    }

//    public void changeScore (Long id, Character bias) {
//        Optional <Student> student = findOneById(id);
//        if (bias.equals(Character.valueOf('+')) && (tempStudent.getScore() + 1) <= 100) {
//            tempStudent.setScore(tempStudent.getScore() + 1);
//            studentRepository.changeScore(tempStudent);
//        } else if (bias.equals(Character.valueOf('-')) && (tempStudent.getScore() - 1) >= 0) {
//            tempStudent.setScore(tempStudent.getScore() - 1);
//            studentRepository.changeScore(tempStudent);
//        }
//    }

    public void decreaseScore (Long id) {
        Optional <Student> student = studentRepository.findOneById(id);
        if (student.isPresent() && student.get().getScore() > 0) {
            studentRepository.decreaseScore(id);
        }
    }
    public void increaseScore (Long id) {
        Optional <Student> student = studentRepository.findOneById(id);
        if (student.isPresent() && student.get().getScore() < 100) {
            studentRepository.increaseScore(id);
        }
    }

}
