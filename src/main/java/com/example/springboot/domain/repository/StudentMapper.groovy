package com.example.springboot.domain.repository

import com.example.springboot.domain.model.Student
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface StudentMapper {

    /**
     * 指定された学生のIDによって学生情報を返す
     * @param id
     * @return
     */
    @Select("select * from tbl_student where id = #{id};")
    Student getStudentById(Integer id);

    /**
     * 条件を満たした学生情報を取得する
     * @return
     */
    @Select('''
        <script>
        select *
        from tbl_student
        <where>
            <if test='id != null'>
              and id = #{id}
            </if>
            <if test='stuName != null'>
             and stu_name like '%${stuName}%'
            </if>
            <if test='sex != null'>
             and sex = #{sex}
            </if>
            <if test='age != null'>
              and age = #{age}
            </if>
        </where> 
        </script>
    ''')
    List<Student> getStudents(Student student);

    /**
     * 学生情報を追加する
     * @param student
     */
    @Insert("insert into tbl_student(stu_name, sex, age) values(#{stuName}, #{sex}, #{age});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer addStudent(Student student);

    /**
     * 学生情報を更新する
     * @param student
     */
    @Update('''
        update tbl_student
        set stu_name = #{stuName},
            sex = #{age},
            age = #{age}
        where id = #{id}
    ''')
    boolean updateStudent(Student student);

    /**
     * 指定されたIDによって学生情報を削除する
     * @param id
     */
    @Delete("delete from tbl_student where id = #{id}")
    boolean deleteStudentById(Integer id);
}
